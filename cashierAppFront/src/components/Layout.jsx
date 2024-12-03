import { useLocation } from "react-router-dom";
import Navbar from "./Navbar";
import Container from "./Container";
import Sidebar from "./Sidebar";

const Layout = ({ children, user }) => {
  const location = useLocation();
  const isLoginPage = location.pathname === "/";

  return (
    <>
      <h1>Welcome {user}</h1>
      {!isLoginPage && (
        <div style={{ display: "flex" }}>
          <Container
            style={{ border: "1px solid black", borderRadius: "20px", flexGrow: 1 }}
          >
            <Navbar />
          </Container>
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
        <div style={{ flexGrow: 4 }}>
          {children}
        </div>
      </div>
    </>
  );
};

export default Layout;