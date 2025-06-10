//import JsxExample from "./components/JSXExample";
//import FunctionalComponent from "./components/FunctionalComponent";
//import ClassComponent from "./components/ClassComponent";
//import PropsExample from "./components/PropsExample";
//import StateExample from './components/StateExample';
import EffectsExample from './components/EffectsExample';
//import ConditionalRendering from './components/ConditionalRendering';
//import ListAndKeys from './components/ListAndKeys';
//import ChildrenExample from './components/ChildrenExample';
//import ControlledUncontrolled from './components/ControlledUncontrolled';

function App() {
  return (
    //<JsxExample/>
    //<FunctionalComponent />
    //<ClassComponent />
    //PropsExample({message: "Parent Component!"})
    //<PropsExample message="Parent Component!" />
    //<StateExample />
    <EffectsExample />
    //<ConditionalRendering isLoggedIn ={false}/>
    //<ListAndKeys />
    // <ChildrenExample> 
    //   <p> This message is passed from parent</p>
    // </ChildrenExample>
    // <ControlledUncontrolled></ControlledUncontrolled>
  );
}

// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

export default App;
