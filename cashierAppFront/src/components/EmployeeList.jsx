import { useEffect, useState } from 'react';
import EmployeeService from '../services/EmployeeService';
import Employee from './Employee';
import EmployeeEditor from './EmployeeEditor';

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    EmployeeService.getAllEmployees()
      .then(response => {
        console.log(response);
        if (Array.isArray(response.data)) {
          setEmployees(response.data);
        } else {
          setError(new Error('Unexpected response format'));
        }
        setLoading(false);
      })
      .catch(error => {
        setError(error);
        setLoading(false);
      });
  }, []);

  const deleteEmployee = (id) => {
    setLoading(true);
    EmployeeService.deleteEmployee(id)
      .then(() => {
        setEmployees(employees.filter(employee => employee.idNumber !== id));
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  }

  const updateEmployee = (updatedEmployee) => {
    console.log(updatedEmployee);
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <div>
      <h1>Employee List</h1>
      <ul>
        {employees.map(employee => (
          <>
          <Employee 
            key={employee.idNumber} 
            name={employee.name} 
            idNumber={employee.idNumber} 
            privilege={employee.privilege} 
            onEmitDelete={deleteEmployee}
            />
          <EmployeeEditor
            key={employee.name}
            name={employee.name}
            idNumber={employee.idNumber}
            privilege={employee.privilege}
            onEmitUpdate={updateEmployee}
            />
            </>
        ))}
      </ul>
    </div>
  );
};

export default EmployeeList;