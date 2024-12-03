import Container from "../components/Container";
import ReportController from "../components/ReportController";
import ReportEditor from "../components/ReportEditor";
import ReportList from "../components/ReportList";

const ReportPage = () => {
  return (
    <>
      <h1>Report Page</h1>
      <Container>
        <ReportController />
      </Container>
    <div style={{display:"flex"}}>
        <ReportList />
      <ReportEditor/>
    </div>
    </>
  );
};

export default ReportPage;
