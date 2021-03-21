const grpc = require('grpc');
const tasksProto = grpc.load('task.proto');

const tasks = [
    {id: 1, title: "Title", description: "Description"}
]

const server = new grpc.Server();

server.addService(
    tasksProto.TaskService.service, {
        list: (_, callback) => {
            console.log(tasks)
            callback(null, tasks)
        },
        save: (task, callback) => {
            console.log(tasks)
            tasks.push(task.request)
            callback(null, tasks)
        }
    }
)

server.bind('127.0.0.1:50051', grpc.ServerCredentials.createInsecure())
console.log('Server running at http://127.0.0.1:50051')
server.start()