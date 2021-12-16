import React from 'react';
import { Routes, Route } from "react-router-dom";

import Edit from './pages/Edit/Edit.jsx';
import Home from './pages/Feed/Home.jsx';
import Lermais from './pages/Lermais/Lermais.jsx'
import Produto from './pages/Produto/Produto.jsx'

function App() {
  return (
    <div className="App">
    <Routes>
      <Route exact path="/" element={<Home />} />
      <Route path="/edit" element={<Edit />} />
      <Route path="/lermais" element={<Lermais />} />
      <Route path="/products" element={<Produto />} />
    </Routes>
    </div>
  );
}

export default App;
