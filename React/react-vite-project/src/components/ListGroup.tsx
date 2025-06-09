import type { MouseEvent } from "react";

function ListGroup() {
  let items = ["New York", "San Francisco", "Tokyo", "London", "Paris"];
  items = [...items, "Berlin", "Madrid", "Rome"]; // Adding more items
  //items = []; // Resetting items to an empty array
  const handleClick = (event: MouseEvent) => {
    console.log(event); // This will log the click event object to the console
  };

  return (
    <>
      <h1>List</h1>
      {items.length === 0 && <p>No items found</p>}
      <ul className="list-group">
        {items.map((item) => (
          <li className="list-group-item" key={item} onClick={handleClick}>
            {item}
          </li>
        ))}
      </ul>
    </>
  );
}

export default ListGroup;
