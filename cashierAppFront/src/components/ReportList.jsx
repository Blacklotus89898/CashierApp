import { useEffect, useState } from "react";
import ReportService from "../services/ReportService";
import Report from "./Report";
import Container from "./Container";

const ReportList = () => {
  const [reports, setReports] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    ReportService.getAllReports()
      .then((response) => {
        console.log(response);
        if (Array.isArray(response.data)) {
          setReports(response.data);
        } else {
          setError(new Error("Unexpected response format"));
        }
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  }, []);

  const deleteReport = (id) => {
    setLoading(true);
    ReportService.deleteReport(id)
      .then(() => {
        setReports(reports.filter((report) => report.idNumber !== id));
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  };

  const updateReport = (updatedReport) => {
    console.log(updatedReport);
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <Container>
      <h1>Report List</h1>
      <ul>
        {reports.map((report) => (
          <li key={report.idNumber}>
            <Report
              idNumber={report.idNumber}
              date={report.date}
              start_time={report.start}
              end_time={report.end}
              content={report.content}
              employeeId={report.employeeId}
              onEmitDelete={deleteReport}
              onEmitUpdate={updateReport}
            />
            <button onClick={() => updateReport(report)}>Update</button>
            <button onClick={() => deleteReport(report.idNumber)}>Delete</button>
          </li>
        ))}
      </ul>
    </Container>
  );
};

export default ReportList;