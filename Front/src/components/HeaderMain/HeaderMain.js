import React from 'react';
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import { Link } from 'react-router-dom'
import { useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from "yup"
import './headerMain.css'

const validationPost = yup.object().shape({
    nome: yup.string().required("O nome é obrigatorio")
      .max(40, "O nome precisa ter menos de 40 caracteres"),

})

function HeaderMain() {

    const navigate = useNavigate();

    const { register, handleSubmit,  formState: { errors } } = useForm({
        resolver: yupResolver(validationPost)
      })

      const addPost = data => 
      axios.post("http://localhost:8080/estoque", data)
    .then(() => {
      console.log("Produto Buscado")
      navigate('/lermais');
    })
    .catch(() => {
      console.log("Acesso Negado")
    })

    return (

        <header>
            <div className="container">

        <div className="btn-New" >
        <Link to="/products">
        <button>Adicionar Produtos</button>
        </Link>
        </div>

        <div className="logo" >
        <h1>Livraria Stark</h1>
        </div>

        <form onSubmit={handleSubmit(addPost)}>
            <div className="fields" >
          <input type="text" name="quantidade" placeholder="Buscar no estoque..." {...register("quantidade")} />
          <p className="error-message">{errors.quantidade?.message}</p>
            </div>
        </form>

            </div>
        </header>

    )
}

export default HeaderMain;