import React from 'react';
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import Header from '../../components/Header/Header'
import { useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from "yup"
import './Produto.css'

const validationPost = yup.object().shape({
  nome: yup.string().required("O nome é obrigatorio")
    .max(40, "O nome precisa ter menos de 40 caracteres"),
  quantidade: yup.string().required("A quantidade é obrigatoria")
    .max(40, "A quantidade precisa ter menos de 40 caracteres"),
  tipo: yup.string().required("O tipo é obrigatorio")
    .max(40, "O tipo precisa ter menos de 40 caracteres"),
  fornecedor: yup.string().required("O fornecedor é obrigatorio")
    .max(40, "O fornecedor precisa ter menos de 40 caracteres"),
  precovenda: yup.string().required("O preco de venda é obrigatorio")
    .max(40, "O preco de venda ter menos de 40 caracteres"),
  precocompra: yup.string().required("O preco de compra é obrigatorio")
    .max(40, "O preco de compra precisa ter menos de 40 caracteres"),
})

function Produto() {

    const navigate = useNavigate();

    const { register, handleSubmit,  formState: { errors } } = useForm({
      resolver: yupResolver(validationPost)
    })

    const addPost = data => 
      axios.post("http://localhost:8080/produtos", data)
    .then(() => {
      console.log("Produto Buscado")
      navigate('/');
    })
    .catch(() => {
      console.log("Acesso Negado")
    })

    return (
        <div>
          <Header />
        <main>

        <div className="card-post" >

        <h1>Produto</h1>
        <div className="line-post" ></div>
       
        <div className="card-body-post" >

        <form onSubmit={handleSubmit(addPost)}>

        <div className="fields" >
          <label>Nome</label>
          <input type="text" name="nome" {...register("nome")} />
          <p className="error-message">{errors.nome?.message}</p>
        </div>

        <div className="fields" >
          <label>Fornecedor</label>
          <input type="text" name="fornecedor" {...register("fornecedor")} />
          <p className="error-message">{errors.fornecedor?.message}</p>
        </div>

        <div className="fields" >
          <label>Tipo</label>
          <input type="text" name="tipo" {...register("tipo")}/>
          <p className="error-message">{errors.tipo?.message}</p>
        </div>

        <div className="fields" >
          <label>Quantidade</label>
          <input type="text" name="quantidade" {...register("quantidade")} />
          <p className="error-message">{errors.quantidade?.message}</p>
        </div>

        <div className="fields" >
          <label>Preco de Venda</label>
          <input type="text" name="precovenda" {...register("precovenda")} />
          <p className="error-message">{errors.precovenda?.message}</p>
        </div>

        <div className="fields" >
          <label>Preco de Compra</label>
          <input type="text" name="precocompra" {...register("precocompra")}/>
          <p className="error-message">{errors.precocompra?.message}</p>
        </div>

        <div className="btn-post" >
          <button type="submit">Buscar</button>
        </div>
        </form>
    
        </div>

      </div>
    
    </main>

      </div>
    )
  }

export default Produto;