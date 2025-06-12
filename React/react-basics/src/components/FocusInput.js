import { useRef } from 'react';

function FocusInput() {
  const inputRef = useRef(null); // sticky note pointing to input box

  const focusInput = () => {
    inputRef.current.focus(); // directly focus the input box
  };

  return (
    <div>
      <input ref={inputRef} placeholder="Click button to focus me" />
      <button onClick={focusInput}>Focus the Input</button>
    </div>
  );
}

export default FocusInput;