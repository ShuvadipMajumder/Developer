import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [employees, setEmployees] = useState([]);
  const [form, setForm] = useState({ name: "", role: "" });

  // Fetch employees from backend
  useEffect(() => {
    axios.get("http://localhost:8080/api/employees")
      .then(res => setEmployees(res.data));
  }, []);

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("http://localhost:8080/api/employees", form)
      .then(res => setEmployees([...employees, res.data]))
      .catch(err => console.error(err));
    setForm({ name: "", role: "" });
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Employee Manager</h1>

      <form onSubmit={handleSubmit}>
        <input
          placeholder="Name"
          value={form.name}
          onChange={e => setForm({ ...form, name: e.target.value })}
        />
        <input
          placeholder="Role"
          value={form.role}
          onChange={e => setForm({ ...form, role: e.target.value })}
        />
        <button type="submit">Add</button>
      </form>

      <ul>
        {employees.map(emp => (
          <li key={emp.id}>{emp.name} - {emp.role}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
