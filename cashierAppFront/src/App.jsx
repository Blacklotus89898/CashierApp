import {Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import Sandbox from './pages/Sandbox'
import './App.css'
import Navbar from './components/Navbar'
import Container from './components/Container'
import Admin from './pages/Admin'
import Login from './pages/Login'
import Sidebar from './components/Sidebar'

function App() {

  return (
    <>
      <Container style={{ border: "1px solid black", borderRadius: "20px" }}>
        <Navbar />
      </Container>
      <div style={{ display: "flex", justifyContent: "space-evenly" }}>
        <Container style={{ border: "1px solid black", borderRadius: "20px" }}>
          <Sidebar />
        </Container>
        <Routes style={{ flexGrow: 2 }}>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<Home />} />
          <Route path="/sandbox" element={<Sandbox />} />
          <Route path="/admin" element={<Admin />} />
        </Routes>
      </div>
    </>
  )
}

export default App
