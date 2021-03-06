/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import dao.PerguntaDao;
import dao.RespostaDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pergunta;
import model.Resposta;

/**
 *
 * @author Marcos
 */
public class Perguntas extends javax.swing.JInternalFrame {

    PerguntaDao perguntaDao;
    RespostaDao respostaDao;
    List<Pergunta> listaPergunta;
    List<Resposta> listaResposta;
    int contador = 0;
    public Perguntas() throws SQLException {
        perguntaDao = new PerguntaDao();
        respostaDao = new RespostaDao();
        
        initComponents();
        this.setVisible(true);
        listaPergunta = perguntaDao.ListaPergunta();
        lbl_pergunta.setText(listaPergunta.get(contador).getDescricao());
        listaResposta = respostaDao.ListaResposta(listaPergunta.get(contador).getId());
        rb_01.setText(listaResposta.get(0).getDescricao());
        rb_02.setText(listaResposta.get(1).getDescricao());
        rb_03.setText(listaResposta.get(2).getDescricao());
        rb_04.setText(listaResposta.get(3).getDescricao());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl_pergunta = new javax.swing.JLabel();
        lbl_resposta = new javax.swing.JTextField();
        rb_01 = new javax.swing.JRadioButton();
        rb_02 = new javax.swing.JRadioButton();
        rb_03 = new javax.swing.JRadioButton();
        rb_04 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        btn_proximo = new javax.swing.JButton();

        lbl_pergunta.setText("Perguntas");

        buttonGroup1.add(rb_01);

        buttonGroup1.add(rb_02);

        buttonGroup1.add(rb_03);

        buttonGroup1.add(rb_04);

        jButton1.setText("Corrigir");

        btn_proximo.setText("Próximo");
        btn_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(btn_proximo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_04)
                            .addComponent(rb_03)
                            .addComponent(lbl_pergunta)
                            .addComponent(lbl_resposta, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rb_01)
                            .addComponent(rb_02))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_pergunta)
                .addGap(18, 18, 18)
                .addComponent(lbl_resposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(rb_01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_03)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_04)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btn_proximo))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proximoActionPerformed
        lbl_resposta.setText("");
        buttonGroup1.clearSelection();
        contador = contador + 1;
        if(listaPergunta.size() > contador){
            try{
                lbl_pergunta.setText(listaPergunta.get(contador).getDescricao());
                listaResposta = respostaDao.ListaResposta(listaPergunta.get(contador).getId());
                rb_01.setText(listaResposta.get(0).getDescricao());
            rb_02.setText(listaResposta.get(1).getDescricao());
            rb_03.setText(listaResposta.get(2).getDescricao());
            rb_04.setText(listaResposta.get(3).getDescricao());
            
            } catch (SQLException ex) {
                Logger.getLogger(Perguntas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, " Fim das Questoes");
            btn_proximo.setEnabled(false);
        }       
            
           
           
        
    }//GEN-LAST:event_btn_proximoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_proximo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbl_pergunta;
    private javax.swing.JTextField lbl_resposta;
    private javax.swing.JRadioButton rb_01;
    private javax.swing.JRadioButton rb_02;
    private javax.swing.JRadioButton rb_03;
    private javax.swing.JRadioButton rb_04;
    // End of variables declaration//GEN-END:variables
}
