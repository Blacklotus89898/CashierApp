import EmployeeList from "../components/EmployeeList";
import EmployeeController from "../components/EmployeeController";
import Container from "../components/Container";

const UserPage = () => {
  return (
    <div>
      <h1>Welcome to the Cashier App</h1>
      <p>This is the User page.</p>
      <Container style={{ border: "1px solid black", borderRadius: "20px" }}>
        <EmployeeController />
        <EmployeeList />
      </Container>
    </div>
  );
};

export default UserPage;
