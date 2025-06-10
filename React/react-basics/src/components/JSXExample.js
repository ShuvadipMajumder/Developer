function JsxExample() {
    const name = "John";
    return (
        <div>
            <h1>Hello, {name}!</h1>
            <p>This is a JSX example.</p>
            <button onClick={() => alert('Button clicked!')}>Click Me</button>
        </div>
    );
}
export default JsxExample;