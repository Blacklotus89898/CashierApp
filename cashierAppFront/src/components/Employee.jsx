import EmployeeService from "../services/EmployeeService";

const Employee = ({ name, idNumber, privilege, onEmitDelete }) => {
    return (
        <div style={{display:"flex"}}>
            <div>
                <h1>{privilege} {name} {idNumber}</h1>
            </div>
            <div>
                <button>Edit</button>
                 <button onClick={() => onEmitDelete(idNumber)}>Delete</button>
            </div>
        </div>
    );
}

export default Employee;
