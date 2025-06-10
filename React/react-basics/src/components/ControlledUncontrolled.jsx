import React, { useState, useRef } from "react";

            // Controlled vs Uncontrolled Input Example
            // Controlled inputs are managed by React state, while uncontrolled inputs manage their own state.
            // Controlled inputs are useful for form validation and dynamic updates.
            // Uncontrolled inputs are useful for simple forms or when you don't need to manage the state.
function ControlledUncontrolled() {

  const [name, setName] = useState("");
  const inputRef = useRef();

  const handleControlledSubmit = (e) => {
    e.preventDefault();
    alert("Controlled Submitted: " + name);
  };

  const handleUncontrolledSubmit = (e) => {
    e.preventDefault();
    alert("Uncontrolled Submitted: " + inputRef.current.value);
  };

  return (
    <div style={{ display: "flex", gap: "50px", padding: "20px" }}>
      <div>
        <h2>Controlled Component</h2>
        <form onSubmit={handleControlledSubmit}>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Enter name"
          />
          <button type="submit">Submit</button>
        </form>
        <p>Typed Name: {name}</p>
      </div>

      <div>
        <h2>Uncontrolled Component</h2>
        <form onSubmit={handleUncontrolledSubmit}>
          <input type="text" ref={inputRef} placeholder="Enter name" />
          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
  );
}

export default ControlledUncontrolled;