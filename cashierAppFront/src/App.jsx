import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Sandbox from "./pages/Sandbox";
import "./App.css";
import Admin from "./pages/Admin";
import Login from "./pages/Login";
import Transaction from "./pages/TransactionPage";
import Product from "./pages/ProductPage";
import ProductType from "./pages/ProductTypePage";
import Report from "./pages/ReportPage";
import { useState, useEffect } from "react";
import userStore from "./stores/userStore";
import Layout from "./components/Layout";
import ErrorBoundary from "./components/ErrorBoundary";

function App() {
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
      <ErrorBoundary>
        <Layout user={user}>
          <Routes>
            <Route path="/" element={<Login onLogin={(formData) => setUser(formData.username)} />} />
            <Route path="/home" element={<Home />} />
            <Route path="/sandbox" element={<Sandbox />} />
            <Route path="/admin" element={<Admin />} />
            <Route path="/product" element={<Product />} />
            <Route path="/productType" element={<ProductType />} />
            <Route path="/transaction" element={<Transaction />} />
            <Route path="/report" element={<Report />} />
            <Route path="*" element={<h1>Not Found</h1>} />
          </Routes>
        </Layout>
      </ErrorBoundary>
  );
}

export default App;