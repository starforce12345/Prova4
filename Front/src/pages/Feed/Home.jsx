/* eslint-disable jsx-a11y/alt-text */
import React, { useState, useEffect } from 'react';
import axios from 'axios'
import { Link } from 'react-router-dom';
import './Home.css'
import HeaderMain from '../../components/HeaderMain/HeaderMain';

function Feed() {

  const [ posts, setPosts ] = useState([])

  useEffect(() => {
    axios.get("http://localhost:8080/produtos")
    .then((response) => {
        setPosts(response.data)
    })

    .catch(() => {
        console.log("Deu errrado")
    })

}, [])

  return (
      <div>
        
        <HeaderMain />
        
        <main>

          <div className="cards"> 

              {posts.map((post) => {
                
                return (
                  <div className="card" >
                
              <header>
                  <h2>{post.nome}</h2>
              </header>

              <div className="line"></div>

              <h3>{post.email}</h3>
              <h3>{post.senha}</h3>
              
              <div className="btns">

                  <div className="btn-edit">
                    <Link to={{ pathname: `/edit/${post._id}` }} >
                        <button>Edit</button>
                    </Link>
                  </div>

                  <div className="btn-readmore">
                    <Link to="/lermais"><button>Readmore</button></Link>
                  </div>

                  <div className="btn-delete">
                  <button>Delete</button>
                  </div>                

              </div>

              </div>
                )

              })}

            </div>

          </main>

      </div>
    )
  }

export default Feed;