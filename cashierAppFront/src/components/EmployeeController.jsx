import { useState } from "react";
import EmployeeService from "../services/EmployeeService";

const EmployeeController = () => {
  const [employee, setEmployee] = useState({
    name: "",
    privilege: "",
    idNumber: "",
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const createEmployee = (employee) => {
    setLoading(true);
    EmployeeService.createEmployee(employee).catch((error) => {
      setError(error);
      setLoading(false);
    });
  };

  const updateEmployee = (id, updatedEmployee) => {
    setLoading(true);
    EmployeeService.updateEmployee(updatedEmployee).catch((error) => {
      setError(error);
      setLoading(false);
    });
  };

  const deleteEmployee = (id) => {
    setLoading(true);
    EmployeeService.deleteEmployee(id)
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
    setEmployee({ ...employee, [name]: value });
  };

  const handleCreateEmployee = (e) => {
    e.preventDefault();
    createEmployee(employee);
    setEmployee({ name: "", privilege: "", idNumber: "" });
  };

  const handleUpdateEmployee = (e) => {
    e.preventDefault();
    updateEmployee(employee.idNumber, employee);
    setEmployee({ name: "", privilege: "", idNumber: "" });
  };

  const handleDeleteEmployee = (e) => {
    e.preventDefault();
    deleteEmployee(employee.idNumber);
    setEmployee({ name: "", privilege: "", idNumber: "" });
  };

  return (
    <div>
      <form>
        <input
          type="text"
          name="name"
          placeholder="Name"
          value={employee.name}
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          value={employee.idNumber}
          placeholder="ID Number"
          onChange={handleInputChange}
          required
        />
        <select
          name="privilege"
          value={employee.privilege}
          onChange={handleInputChange}
          required
        >
          <option value="">Select Privilege</option>
          <option value="boss">Boss</option>
          <option value="employee">Employee</option>
          <option value="manager">Manager</option>
        </select>
        <button onClick={handleCreateEmployee}>Add Employee</button>
        <button onClick={handleUpdateEmployee}>Update Employee</button>
        <button onClick={handleDeleteEmployee}>Delete Employee</button>
      </form>
    </div>
  );
};

export default EmployeeController;
