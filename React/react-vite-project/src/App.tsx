import GiftBox from "./components/GiftBox";

function App() {
  return (
    <GiftBox>
      <p>Teddy Bear 🧸</p>
    </GiftBox>
  );

  // Example usage of the GreetingCard component
  // const name = "Alice";
  // const message = "Wishing you a fantastic birthday!";
  // const handleReply = (reply: string) => {
  //   console.log("Reply received:", reply);
  // };
  // return (
  //   <>
  //     <GreetingCard name={name} message={message} onReply={handleReply} />
  //   </>
  // );
}

export default App;

//Default Code for a Vite + React project
// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
// import './App.css'

// function App() {
//   const [count, setCount] = useState(0)

//   return (
//     <>
//       <div>
//         <a href="https://vite.dev" target="_blank">
//           <img src={viteLogo} className="logo" alt="Vite logo" />
//         </a>
//         <a href="https://react.dev" target="_blank">
//           <img src={reactLogo} className="logo react" alt="React logo" />
//         </a>
//       </div>
//       <h1>Vite + React</h1>
//       <div className="card">
//         <button onClick={() => setCount((count) => count + 1)}>
//           count is {count}
//         </button>
//         <p>
//           Edit <code>src/App.tsx</code> and save to test HMR
//         </p>
//       </div>
//       <p className="read-the-docs">
//         Click on the Vite and React logos to learn more
//       </p>
//     </>
//   )
// }

// export default App
