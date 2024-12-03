import PropTypes from "prop-types";
import Container from "./Container";
import { useState } from "react";

const ReportEditor = ({
  idNumber,
  title,
  date,
  employeeId,
  start_time,
  end_time,
  onEmitUpdate,
}) => {
  const [report, setReport] = useState({
    idNumber,
    title,
    date,
    employeeId,
    start_time,
    end_time,
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setReport({ ...report, [name]: value });
  };

  const handleUpdate = () => {
    onEmitUpdate(report);
  };

  return (
    <Container>
      <h2>Edit Report</h2>
      <form>
        <div>
          <label>ID Number:</label>
          <input
            type="text"
            name="idNumber"
            value={report.idNumber}
            onChange={handleInputChange}
            disabled
          />
        </div>
        <div>
          <label>Title:</label>
          <input
            type="text"
            name="title"
            value={report.title}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Date:</label>
          <input
            type="date"
            name="date"
            value={report.date}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Employee ID:</label>
          <input
            type="text"
            name="employeeId"
            value={report.employeeId}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Start Time:</label>
          <input
            type="time"
            name="start_time"
            value={report.start_time}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>End Time:</label>
          <input
            type="time"
            name="end_time"
            value={report.end_time}
            onChange={handleInputChange}
          />
        </div>
        <button type="button" onClick={handleUpdate}>
          Update
        </button>
      </form>
    </Container>
  );
};

ReportEditor.propTypes = {
  idNumber: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  date: PropTypes.string.isRequired,
  employeeId: PropTypes.string.isRequired,
  start_time: PropTypes.string.isRequired,
  end_time: PropTypes.string.isRequired,
  onEmitUpdate: PropTypes.func.isRequired,
};

export default ReportEditor;
