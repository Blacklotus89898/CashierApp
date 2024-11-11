import { useEffect, useState } from 'react';
import EmployeeService from '../services/EmployeeService';

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
          <li key={employee.idNumber}>
            {employee.name} - {employee.privilege}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EmployeeList;