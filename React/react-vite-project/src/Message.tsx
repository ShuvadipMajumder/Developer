
//PascalCase component name
function Message(){
    //JSX syntax JavaScript XML
    //This is a functional component in React
    const name = "Message Component";
    console.log(name); // This will log "Message Component" to the console
    return (
        <div className="message">
        <p>This is a {name}.</p>
        </div>
    );
}
//Export the component
export default Message;