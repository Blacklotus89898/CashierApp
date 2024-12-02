import { Route, Routes, useLocation } from "react-router-dom";
import Home from "./pages/Home";
import Sandbox from "./pages/Sandbox";
import "./App.css";
import Navbar from "./components/Navbar";
import Container from "./components/Container";
import Admin from "./pages/Admin";
import Login from "./pages/Login";
import Sidebar from "./components/Sidebar";
import Transaction from "./pages/TransactionPage";
import Product from "./pages/ProductPage";
import ProductType from "./pages/ProductTypePage";
import Report from "./pages/ReportPage";
import { useState, useEffect } from "react";
import userStore from "./stores/userStore";

function App() {
  const location = useLocation();
  const isLoginPage = location.pathname === "/";
  const [user, setUser] = useState("Guest");
  
  
  useEffect(() => {
    const handleUserChange = () => {
      setUser(userStore.getState().user);
    };

    // Subscribe to changes (if needed)
    // For simplicity, we'll just update the state directly here
    userStore.handleUserChange = handleUserChange;

    return () => {
      // Cleanup subscription (if needed)
      userStore.handleUserChange = null;
    };
  }, []);

  return (
    <>
      {!isLoginPage && (
        <div style={{display:"flex"}}>
          <Container
            style={{ border: "1px solid black", borderRadius: "20px" }}
          >
            <Navbar />
          </Container>
          <h1>Welcome {user}</h1>
        </div>
      )}

      <div style={{ display: "flex", justifyContent: "flex-start" }}>
        {!isLoginPage && (
          <Container
            style={{ border: "1px solid black", borderRadius: "20px", flexGrow: 0.1 }}
          >
            <Sidebar />
          </Container>
        )}

        <Routes style={{ flexGrow: 4 }}>
        <Route path="/" element={<Login onLogin={(formData) => {
            setUser(formData.username);
          }} />} />
          <Route path="/home" element={<Home />} />
          <Route path="/sandbox" element={<Sandbox />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/product" element={<Product />} />
          <Route path="/productType" element={<ProductType />} />
          <Route path="/transaction" element={<Transaction />} />
          <Route path="/report" element={<Report />} />
          <Route path="*" element={<h1>Not Found</h1>} />
        </Routes>
      </div>
    </>
  );
}

export default App;
