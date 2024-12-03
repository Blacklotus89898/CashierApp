import { useState } from "react";
import { useLocation } from "react-router-dom";
import Navbar from "./Navbar";
import Sidebar from "./Sidebar";
import Container from "./Container";

const Layout = ({ children, user }) => {
    const location = useLocation();
    const isLoginPage = location.pathname === "/";
    const [isSidebarCollapsed, setIsSidebarCollapsed] = useState(false);

    const toggleSidebar = () => {
        setIsSidebarCollapsed(!isSidebarCollapsed);
    };

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

            <div style={{ display: "flex" }}>
                {!isLoginPage && (
                    <Container
                        style={{
                            border: "1px solid black",
                            borderRadius: "20px",
                            width: isSidebarCollapsed ? "10px" : "200px",
                            transition: "width 1s",
                            overflow: "hidden",
                            flexGrow: 0,
                        }}
                    >
                        <button onClick={toggleSidebar}>
                            {isSidebarCollapsed ? ">" : "<"}
                        </button>
                        {!isSidebarCollapsed && <Sidebar />}
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