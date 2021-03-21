const client = require('./client-gprc')

const handler = (err, task) => {
    if (err) console.log(err)
    else console.log(task)
}

// client.list({}, handler)

client.save (
    { id: 1, title: "Title", description: "Description", date: "2021-01-01"},
    handler
)