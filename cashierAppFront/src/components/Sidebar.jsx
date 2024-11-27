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
        <Link to="/">Login</Link>
      </div>
      <div>
        <Link to="/home">Home</Link>
      </div>
      <div>
        <Link to="/sandbox">Sandbox</Link>
      </div>
      <div>
        <Link to="/admin">Admin</Link>
      </div>
      <div>
        <Link to="/product">Product</Link>
      </div>
      <div>
        <Link to="/productType">Product Type</Link>
      </div>
      <div>
        <Link to="/transaction">Transaction</Link>
      </div>
      <div>
        <Link to="/report">Report</Link>
      </div>
    </nav>
  );
};

export default Sidebar;
