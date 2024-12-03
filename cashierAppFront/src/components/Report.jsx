import PropTypes from 'prop-types';

const Report = ({ idNumber, title, date, employeeId, start_time, end_time, onEmitDelete, onEmitUpdate }) => {
  return (
    <li>
      <h2>{idNumber}{title}</h2>
      <p>
      {date}: {start_time} - {end_time}
      </p>
      <p>Employee ID: {employeeId}</p>
      <button onClick={() => onEmitDelete(idNumber)}>Delete</button>
      <button onClick={() => onEmitUpdate(idNumber)}>Update</button>
    </li>
  );
};

Report.propTypes = {
  idNumber: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  date: PropTypes.string.isRequired,
  employeeId: PropTypes.string.isRequired,
  start_time: PropTypes.string.isRequired,
  end_time: PropTypes.string.isRequired,
  onEmitDelete: PropTypes.func.isRequired,
  onEmitUpdate: PropTypes.func.isRequired,
};

export default Report;