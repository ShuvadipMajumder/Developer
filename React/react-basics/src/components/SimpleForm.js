import React, { useState } from 'react';

function SimpleForm() {
  // Use useState to manage the input value
  const [name, setName] = useState(''); // Initialize state with an empty string

  // Event handler for input changes
  const handleChange = (event) => {
    setName(event.target.value); // Update the 'name' state with the input value
  };

  // Event handler for form submission
  const handleSubmit = (event) => {
    event.preventDefault(); // Prevent the default form submission (page reload)
    alert('Submitted Name: ' + name); // Display the submitted name in an alert
  };

  return (
    <form onSubmit={handleSubmit}> {/* Call handleSubmit when the form is submitted */}
      <label>
        Name:
        <input
          type="text"
          value={name} // Bind the input value to the 'name' state
          onChange={handleChange} // Call handleChange on input changes
        />
      </label>
      <button type="submit">Submit</button> {/* Submit button */}
    </form>
  );
}

export default SimpleForm;