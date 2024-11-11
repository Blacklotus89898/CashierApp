import {Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import Sandbox from './pages/Sandbox'
import './App.css'
import Navbar from './components/Navbar'

function App() {

  return (
    <>
      <Navbar />
      <Routes>
      <Route path="/" element={<Home/>} />
      <Route path="/sandbox" element={<Sandbox/>} />
      </Routes>

    </>
  )
}

export default App
