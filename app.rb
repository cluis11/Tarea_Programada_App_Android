require "./Usuarios.rb"
require "./Preguntas.rb"
require "./Respuestas.rb"

$U = Usuarios.new()
$P = Preguntas.new()
$R = Respuestas.new()

get '/' do                                  
 "Prueba"
end

get '/usuarios' do
 @user=$U.usuarios_()
 @user
end

get '/get_usuario/:user' do
 @temp=params[:user]
 @user=$U.nuevo_usuario(@temp)
 @user
end

get '/preguntas' do
 @preg=$P.preguntas_()
 @preg
end

get '/get_pregunta/:preg' do
 @temp=params[:preg]
 @preg=$P.nueva_pregunta(@temp)
 @preg
end

get '/respuestas' do
 @res=$R.respuestas_()
 @res
end
