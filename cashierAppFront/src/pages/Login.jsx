import { Link } from "react-router-dom";
import { useState } from "react";

const Login = () => {
  const [showform, setShowForm] = useState(false);
  const handleSubmit = (event) => {
    event.preventDefault();
    // Add your login logic here
    window.location.href = "/home";
  };

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        height: "100vh",
        textAlign: "center",
        flexGrow: 1,
      }}
    >
      <h1>Welcome to the Cashier App</h1>
      <p>This is the Login page.</p>
      {!showform && 
      <button onClick={() => setShowForm(!showform)}>Login</button>
      }

      {showform && (
        <form
          style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
          onSubmit={handleSubmit}
        >
          <div>
            <label htmlFor="username">Username:</label>
            <input type="text" id="username" name="username" />
          </div>
          <div>
            <label htmlFor="password">Password:</label>
            <input type="password" id="password" name="password" />
          </div>
          <button type="submit">Submit</button>
        </form>
      )}
      {/* <div>
        <Link to="/home">Go to Home Page</Link>
      </div> */}
    </div>
  );
};

export default Login;
