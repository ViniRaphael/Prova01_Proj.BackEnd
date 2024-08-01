package logistica.prova01.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pacote {

    @Id
    private String id;
    private String destinatario;

    @ManyToOne
    @JoinColumn(name = "endereco_cep")
    private Endereco endereco;

    private String status;

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL)
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = novoStatus;
        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setStatus(novoStatus);
        rastreamento.setDataHora(dataHora);
        rastreamento.setLocalizacao(localizacao);
        rastreamento.setPacote(this);
        this.rastreamentos.add(rastreamento);
    }

    public String consultarInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pacote ID: ").append(id).append("\n");
        sb.append("Destinatário: ").append(destinatario).append("\n");
        sb.append("Endereço: ").append(endereco.getEnderecoCompleto()).append("\n");
        sb.append("Status Atual: ").append(status).append("\n");
        sb.append("Rastreamento Histórico:\n");
        for (Rastreamento r : rastreamentos) {
            sb.append(r.getResumo()).append("\n");
        }
        return sb.toString();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Rastreamento> getRastreamentos() { return rastreamentos; }
    public void setRastreamentos(List<Rastreamento> rastreamentos) { this.rastreamentos = rastreamentos; }
}

