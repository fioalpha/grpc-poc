
const grpc = require('grpc')
const PROTO_PATH = './task.proto'
const NoteService = grpc.load(PROTO_PATH).TaskService

const client = new NoteService('localhost:50051', grpc.credentials.createInsecure())
    
module.exports = client