import {Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import Sandbox from './pages/Sandbox'
import './App.css'
import Navbar from './components/Navbar'
import Container from './components/Container'

function App() {

  return (
    <>
    <Container style={{ border: "1px solid black", borderRadius: "20px" }}>
      <Navbar />
    </Container>
      <Routes>
      <Route path="/" element={<Home/>} />
      <Route path="/sandbox" element={<Sandbox/>} />
      </Routes>

    </>
  )
}

export default App
