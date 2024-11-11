import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav style={{ display: "flex", justifyContent: "space-around" }}>
      <div>
        <Link to="/">Home</Link>
      </div>
      <div>
        <Link to="/sandbox">Sandbox</Link>
      </div>
    </nav>
  );
};

export default Navbar;
