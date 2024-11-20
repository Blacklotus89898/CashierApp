import { useState } from "react";
import ReportService from "../services/ReportService";

const ReportController = () => {
  const [report, setReport] = useState({
    title: "",
    content: "",
    employeeId: "",
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const createReport = (report) => {
    setLoading(true);
    ReportService.createReport(report)
      .then(() => {
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  };

  const updateReport = (id, updatedReport) => {
    setLoading(true);
    ReportService.updateReport(id, updatedReport)
      .then(() => {
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  };

  const deleteReport = (id) => {
    setLoading(true);
    ReportService.deleteReport(id)
      .then(() => {
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setReport({ ...report, [name]: value });
  };

  const handleCreateReport = (e) => {
    e.preventDefault();
    createReport(report);
    setReport({ title: "", content: "", employeeId: "" });
  };

  const handleUpdateReport = (e) => {
    e.preventDefault();
    updateReport(report.id, report);
    setReport({ title: "", content: "", employeeId: "" });
  };

  const handleDeleteReport = (e) => {
    e.preventDefault();
    deleteReport(report.id);
    setReport({ title: "", content: "", employeeId: "" });
  };

  return (
    <div>
      <form>
        <input
          type="text"
          name="title"
          placeholder="Title"
          value={report.title}
          onChange={handleInputChange}
          required
        />
        <textarea
          name="content"
          placeholder="Content"
          value={report.content}
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="employeeId"
          placeholder="Employee ID"
          value={report.employeeId}
          onChange={handleInputChange}
          required
        />
        <button onClick={handleCreateReport}>Add Report</button>
        <button onClick={handleUpdateReport}>Update Report</button>
        <button onClick={handleDeleteReport}>Delete Report</button>
      </form>
    </div>
  );
};

export default ReportController;