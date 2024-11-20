import Container from "../components/Container";
import ReportController from "../components/ReportController";
import ReportList from "../components/ReportList";

const ReportPage = () => {
  return (
    <div>
      <h1>Welcome to the Cashier App</h1>
      <p>This is the Report page.</p>
      <Container style={{ border: "1px solid black", borderRadius: "20px" }}>
        <ReportController />
        <ReportList />
      </Container>
    </div>
  );
};

export default ReportPage;
