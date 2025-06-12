import { useState, useRef } from "react";

function UseRefExample() {

    const[counter, setCounter] =useState(0);
    const renderCount = useRef(0);
    renderCount.current += 1; // Increment render count on every render
    const previousCounter = useRef(counter); // Store previous counter value
    previousCounter.current = counter; // Update previous counter value on every render
    return (
        <div>
            <h1>Counter: {counter}</h1>
            <h2>Render Count: {renderCount.current}</h2>
            <h2>Previous Counter: {previousCounter.current}</h2>
            <button onClick={() => setCounter(counter + 1)}>Increment</button>
            <button onClick={() => setCounter(counter - 1)}>Decrement</button>
            <button onClick={() => setCounter(0)}>Reset</button>
        </div>
    );

}
export default UseRefExample;