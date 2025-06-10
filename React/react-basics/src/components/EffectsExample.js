import { useState, useEffect } from "react";

function EffectsExample() {
    const [count, setCount] =useState(0);

    // useEffect is called after every render
    useEffect(() => {
        document.title = `Count: ${count}`;
        console.log(`Count has been updated to: ${count}`);
    },[count]);

    return (
        <div>
            <h1>Counter: {count}</h1>
            <button onClick={() => setCount(count + 1)}>Increment</button>
            <button onClick={() => setCount(count - 1)}>Decrement</button>
            <button onClick={() => setCount(0)}>Reset</button>
        </div>
    );
    
}
export default  EffectsExample;