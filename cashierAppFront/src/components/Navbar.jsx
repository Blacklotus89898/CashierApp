import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav style={{ display: "flex", justifyContent: "space-around", padding:" 1em" }}>
      <div>
        <Link to="/">Login</Link>
      </div>
      <div>
        <Link to="/home">Home</Link>
      </div>
      <div>
        <Link to="/admin">Admin</Link>
      </div>
      <div>
        <Link to="/report">Report</Link>
      </div>
      <div>
        <Link to="/employee">Employee</Link>
      </div>
      <div>
        <Link to="/sandbox">Sandbox</Link>
      </div>
    </nav>
  );
};

export default Navbar;
