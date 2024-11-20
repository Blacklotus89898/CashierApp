import { useState } from "react";

const EmployeeEditor = ({ name, idNumber, privilege, onEmitUpdate })=> {

    const [employee, setEmployee] = useState({
        name: name,
        privilege: privilege,
        idNumber: idNumber,
        });

    const handleInput = (e) => {
        const { name, value } = e.target;
        setEmployee({ ...employee, [name]: value });
    }

    return (
        <div style={{ border: "1px solid black", borderRadius: "20px" }}>
            <h1> {name} </h1>
            
            <input type="text" name="name" value={employee.name} onChange={handleInput}/>
            <input type="text" name="privilege" value={employee.privilege} onChange={handleInput}/>
            <div>
                 <button onClick={() => onEmitUpdate(employee)}>Update</button>
                 <button>Cancel</button>
                 <div>
                    {employee.name} {employee.idNumber} {employee.privilege}
                 </div>
            </div>
        </div>
    );
}

export default EmployeeEditor;
