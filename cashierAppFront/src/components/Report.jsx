const Report = ({ idNumber, title, date, employeeId, onEmitDelete }) => {
  return (
    <li>
      <h2>{idNumber}{title}</h2>
      <p>{date}</p>
      <p>Employee ID: {employeeId}</p>
      <button onClick={() => onEmitDelete(id)}>Delete</button>
    </li>
  );
};

export default Report;