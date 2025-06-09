interface GiftBoxProps {
  children: React.ReactNode; // This allows any React elements to be passed inside the GiftBox
}

function GiftBox({ children }: GiftBoxProps) {
  return (
    <div
      style={{
        border: "2px solid gold",
        padding: "20px",
        marginBottom: "10px",
      }}
    >
      <h3>🎁 A Special Gift Just for You!</h3>
      <div>{children}</div> {/* This renders whatever was passed inside */}
    </div>
  );
}

export default GiftBox;
