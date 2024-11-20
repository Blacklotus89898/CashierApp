import EmployeeService from "../services/EmployeeService";

const Employee = ({ name, idNumber, privilege, onEmitDelete }) => {
  return (
    <div style={{ border: "1px solid black", borderRadius: "20px" }}>
      <div>
        <h1>
          Privilege:{privilege} | Name: {name} | ID Number: {idNumber}
        </h1>
      </div>
      <div>
        {/* <button>Edit</button> */}
        <button onClick={() => onEmitDelete(idNumber)}>Delete</button>
      </div>
    </div>
  );
};

export default Employee;
