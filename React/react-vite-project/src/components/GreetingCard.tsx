interface GreetingCardProps {
  name: string;
  message: string;
  onReply: (reply: string) => void;
}

// function GreetingCard(GreetingCardProps: GreetingCardProps) {
//   return (
//     <div className="greeting-card">
//       <h1>Hello, {GreetingCardProps.name}!</h1>
//       <p>{GreetingCardProps.message}</p>
//     </div>
//   );
// }

function GreetingCard({ name, message, onReply }: GreetingCardProps) {
  const handleReplyClick = () => {
    const reply = `Thank you for the message. from ${name}!`;
    onReply(reply);
  };

  return (
    <div className="greeting-card">
      <h1>Hello, {name}!</h1>
      <p>{message}</p>
      <button onClick={handleReplyClick}>Reply</button>
    </div>
  );
}
export default GreetingCard;
