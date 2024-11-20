import { Link } from "react-router-dom";

const Sidebar = () => {
  return (
    <nav
      style={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "space-around",
        height: "100vh",
        alignItems: "center",
      }}
    >
      <div>
        <Link to="/">Home</Link>
      </div>
      <div>
        <Link to="/sandbox">Sandbox</Link>
      </div>
    </nav>
  );
};

export default Sidebar;
