import { useEffect, useState } from "react";
import ReportService from "../services/ReportService";
import Report from "./Report";

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

  // const updateReport = (updatedReport) => {
  //   console.log(updatedReport);
  // };

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <div>
      <h1>Report List</h1>
      <ul>
        {reports.map((report) => (
          <>
            <Report
              key={report.idNumber}
              idNumber={report.idNumber}
              date={report.date}
              content={report.content}
              employeeId={report.employeeId}
              onEmitDelete={deleteReport}
            />
          </>
        ))}
      </ul>
    </div>
  );
};

export default ReportList;