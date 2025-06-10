function ListAndKeys(){
    const fruits =[ 'apple', 'banana', 'cherry', 'date'  ];
    return (
        <div>
            <h2>List of Fruits</h2>
            <ul>
                {fruits.map((fruit,index) => (<li key ={index}>{fruit}</li>)
                )}
                </ul>
        </div>
    );
}
export default ListAndKeys;