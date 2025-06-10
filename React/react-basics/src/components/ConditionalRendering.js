function ConditionalRendering ({isLoggedIn}){
    return(
        <div>
            {isLoggedIn ? <h4>Welcome back!</h4> : <h4>Please login.</h4>}
        </div>
    );
}
export default ConditionalRendering