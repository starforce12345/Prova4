import React, { useEffect} from 'react';
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'
import { useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from "yup"
import Header from '../../components/Header/Header'

const validationPost = yup.object().shape({
  nome: yup.string().required("O nome é obrigatorio")
    .max(40, "O nome precisa ter menos de 40 caracteres"),
  email: yup.string().required("O sobrenome é obrigatorio")
    .max(40, "O sobrenome precisa ter menos de 40 caracteres"),
  senha: yup.string().required("Os hobbies são obrigatorios")
    .max(90, "Os hobbies precisa ter menos de 90 caracteres"),
})

function Edit() {

  const { id } = useParams()

  const navigate = useNavigate();

  const { register, handleSubmit,  formState: { errors }, reset } = useForm({
    resolver: yupResolver(validationPost)
  })

  useEffect(() => {
    axios.get(`http://localhost:8080/usuarios/${id}`)
    .then((response) => {
      reset(response.data)
      })

  }, )

  const addPost = data => axios.post("http://localhost:8080/usuarios", data)
.then(() => {
  console.log("Usuario Cadastrado")
  navigate('/');
})
    return (
      <div>
        <Header />

        <main>

        <div className="card-post" >

        <h1>Criar postagem</h1>
        <div className="line-post" ></div>
       
        <div className="card-body-post" >

        <form onSubmit={handleSubmit(addPost)}>

        <div className="fields" >
          <label>Nome</label>
          <input type="text" name="nome" {...register("nome")} />
          <p className="error-message">{errors.nome?.message}</p>
        </div>

        <div className="fields" >
          <label>Email</label>
          <input type="text" name="email" {...register("email")} />
          <p className="error-message">{errors.email?.message}</p>
        </div>

        <div className="fields" >
          <label>Senha</label>
          <input type="password" name="senha" {...register("senha")}/>
          <p className="error-message">{errors.senha?.message}</p>
        </div>

        <div className="btn-post" >
          <button type="submit">Enviar</button>
        </div>
        </form>
    
        </div>

      </div>
    
    </main>
      </div>
    );
  }

export default Edit;