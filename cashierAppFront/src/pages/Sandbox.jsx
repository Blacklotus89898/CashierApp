import Container from "../components/Container";
import EmployeeList from "../components/EmployeeList";
import EmployeeController from "../components/EmployeeController";
import ReportController from "../components/ReportController";
import ReportList from "../components/ReportList";

const Sandbox = () => {
  return (
    <div>
      <h1>Welcome to the Cashier App</h1>
      <p>This is the Sandbox page.</p>
      {/* <Container style={{ border: "1px solid black", borderRadius: "20px" }}>
        <EmployeeController />
        <EmployeeList />
      </Container> */}
      <Container style={{ border: "1px solid black", borderRadius: "20px" }}>
        <ReportController />
        <ReportList />
      </Container>
    </div>
  );
};

export default Sandbox;
