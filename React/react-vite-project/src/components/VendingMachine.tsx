import { useState } from "react";

function VendingMachine() {
  const [balance, setBalance] = useState(0);

  const insertCoin = () => {
    setBalance(balance + 1);
  };

  return (
    <div>
      <h2>Vending Machine</h2>
      <p>Balance : ${balance}</p>
      <button onClick={insertCoin}>Insert $1</button>
    </div>
  );
}
export default VendingMachine;
